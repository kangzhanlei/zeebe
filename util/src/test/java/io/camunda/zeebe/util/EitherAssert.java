/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.1. You may not use this file
 * except in compliance with the Zeebe Community License 1.1.
 */
package io.camunda.zeebe.util;

import java.util.Objects;
import javax.annotation.processing.Generated;
import org.assertj.core.api.AbstractObjectAssert;

/**
 * {@link Either} specific assertions - Generated by CustomAssertionGenerator. Generified by Zeebe
 * team.
 */
@Generated(value = "assertj-assertions-generator")
public class EitherAssert<L, R> extends AbstractObjectAssert<EitherAssert<L, R>, Either<L, R>> {

  /**
   * Creates a new <code>{@link EitherAssert}</code> to make assertions on actual Either.
   *
   * @param actual the Either we want to make assertions on.
   */
  public EitherAssert(Either<L, R> actual) {
    super(actual, EitherAssert.class);
  }

  /**
   * An entry point for EitherAssert to follow AssertJ standard <code>assertThat()</code>
   * statements.<br>
   * With a static import, one can write directly: <code>assertThat(myEither)</code> and get
   * specific assertion with code completion.
   *
   * @param actual the Either we want to make assertions on.
   * @return a new <code>{@link EitherAssert}</code>
   */
  @org.assertj.core.util.CheckReturnValue
  public static <L, R> EitherAssert<L, R> assertThat(Either<L, R> actual) {
    return new EitherAssert<>(actual);
  }

  /**
   * Verifies that the actual Either's left is equal to the given one.
   *
   * @param left the given left to compare the actual Either's left to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Either's left is not equal to the given one.
   */
  public EitherAssert<L, R> hasLeft(L left) {
    // check that actual Either we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    final String assertjErrorMessage =
        "\nExpecting left of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    final L actualLeft = actual.getLeft();
    if (!Objects.deepEquals(actualLeft, left)) {
      failWithMessage(assertjErrorMessage, actual, left, actualLeft);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Either is left.
   *
   * @return this assertion object.
   * @throws AssertionError - if the actual Either is not left.
   */
  public EitherAssert<L, R> isLeft() {
    // check that actual Either we want to make assertions on is not null.
    isNotNull();

    // check that property call/field access is true
    if (!actual.isLeft()) {
      failWithMessage("\nExpecting that actual Either is left but is not.");
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Either is not left.
   *
   * @return this assertion object.
   * @throws AssertionError - if the actual Either is left.
   */
  public EitherAssert<L, R> isNotLeft() {
    // check that actual Either we want to make assertions on is not null.
    isNotNull();

    // check that property call/field access is false
    if (actual.isLeft()) {
      failWithMessage("\nExpecting that actual Either is not left but is.");
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Either is right.
   *
   * @return this assertion object.
   * @throws AssertionError - if the actual Either is not right.
   */
  public EitherAssert<L, R> isRight() {
    // check that actual Either we want to make assertions on is not null.
    isNotNull();

    // check that property call/field access is true
    if (!actual.isRight()) {
      failWithMessage("\nExpecting that actual Either is right but is not.");
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Either is not right.
   *
   * @return this assertion object.
   * @throws AssertionError - if the actual Either is right.
   */
  public EitherAssert<L, R> isNotRight() {
    // check that actual Either we want to make assertions on is not null.
    isNotNull();

    // check that property call/field access is false
    if (actual.isRight()) {
      failWithMessage("\nExpecting that actual Either is not right but is.");
    }

    // return the current assertion for method chaining
    return this;
  }
}