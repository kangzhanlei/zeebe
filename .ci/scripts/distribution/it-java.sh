#!/bin/bash -eux

source "${BASH_SOURCE%/*}/../lib/flaky-tests.sh"

# getconf is a POSIX way to get the number of processors available which works on both Linux and macOS
LIMITS_CPU=${LIMITS_CPU:-$(getconf _NPROCESSORS_ONLN)}
MAVEN_PARALLELISM=${MAVEN_PARALLELISM:-$LIMITS_CPU}
SUREFIRE_FORK_COUNT=${SUREFIRE_FORK_COUNT:-}
JUNIT_THREAD_COUNT=${JUNIT_THREAD_COUNT:-}
MAVEN_PROPERTIES=(
  -DskipUTs
  -DskipChecks
  -DtestMavenId=2
  -Dfailsafe.rerunFailingTestsCount=7
  -Dflaky.test.reportDir=failsafe-reports
)
tmpfile=$(mktemp)

if [ ! -z "$SUREFIRE_FORK_COUNT" ]; then
  MAVEN_PROPERTIES+=("-DforkCount=$SUREFIRE_FORK_COUNT")
fi

if [ ! -z "$JUNIT_THREAD_COUNT" ]; then
  MAVEN_PROPERTIES+=("-DjunitThreadCount=$JUNIT_THREAD_COUNT")
fi

mvn -o -B --fail-never -T${MAVEN_PARALLELISM} -s ${MAVEN_SETTINGS_XML} \
  -P parallel-tests,extract-flaky-tests "${MAVEN_PROPERTIES[@]}" \
  verify | tee ${tmpfile}
status=${PIPESTATUS[0]}

# delay checking the maven status after we've analysed flaky tests
analyseFlakyTests "${tmpfile}" "./FlakyTests.txt" || exit $?

if [[ $status != 0 ]]; then
  exit $status;
fi

if grep -q "\[INFO\] Build failures were ignored\." ${tmpfile}; then
  exit 1
fi
