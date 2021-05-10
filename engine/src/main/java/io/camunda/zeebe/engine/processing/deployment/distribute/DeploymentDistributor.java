/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.1. You may not use this file
 * except in compliance with the Zeebe Community License 1.1.
 */
package io.camunda.zeebe.engine.processing.deployment.distribute;

import io.camunda.zeebe.util.sched.future.ActorFuture;
import org.agrona.DirectBuffer;

public interface DeploymentDistributor {
  ActorFuture<Void> pushDeploymentToPartition(
      long key, int partitionId, DirectBuffer deploymentBuffer);
}
