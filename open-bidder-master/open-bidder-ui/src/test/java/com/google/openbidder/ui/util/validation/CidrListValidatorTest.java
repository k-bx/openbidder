/*
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openbidder.ui.util.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Tests for {@link CidrListValidator}.
 */
public class CidrListValidatorTest {
  private CidrListValidator validator;

  @Before
  public void setUp() {
    validator = new CidrListValidator();
    validator.initialize(null);
  }

  @Test
  public void testEmptyCidrList() {
    assertTrue(validator.isValid(Collections.<String>emptyList(), null));
  }

  @Test
  public void testValidCidrList() {
    List<String> validCidrList = ImmutableList.of(
        "198.51.100.1/24",
        "198.51.100.0/22",
        "2001:db8::/48",
        "198.51.100.1",
        "2001:db8:0:0:0:0:0:0");
    assertTrue(validator.isValid(validCidrList, null));
  }

  @Test
  public void testInvalidCidrList() {
    List<String> invalidCidrList = ImmutableList.of(
        "aaa",
        "198.2",
        "198.2.4/24",
        "198.2.4.1/60");
    assertFalse(validator.isValid(invalidCidrList, null));
  }
}
