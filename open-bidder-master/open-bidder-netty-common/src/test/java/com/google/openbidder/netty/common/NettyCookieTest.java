/*
 * Copyright 2014 Google Inc. All Rights Reserved.
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

package com.google.openbidder.netty.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.openbidder.http.Cookie;
import com.google.openbidder.util.testing.TestUtil;

import org.junit.Test;

import io.netty.handler.codec.http.DefaultCookie;

/**
 * Tests for {@link NettyCookie}.
 */
public class NettyCookieTest {

  @Test
  public void testCommonMethods() {
    Cookie cookie1 = new NettyCookie(newNettyCookie("comment1"));
    Cookie cookie2 = new NettyCookie(NettyCookie.getNettyCookie(cookie1));
    Cookie cookie3 = new NettyCookie(cookie1.toBuilder().setComment("comment3").build());
    TestUtil.testCommonMethods(cookie1, cookie2, cookie3);

    assertEquals("name", cookie1.getName());
    assertEquals("value", cookie1.getValue());
    assertEquals("domain", cookie1.getDomain());
    assertEquals("path", cookie1.getPath());
    assertEquals(false, cookie1.isSecure());
    assertEquals("comment1", cookie1.getComment());
    assertEquals(1, cookie1.getMaxAge());
    assertEquals(1, cookie1.getVersion());
    assertNotNull(cookie1.toBuilder().build());
  }

  private static io.netty.handler.codec.http.Cookie newNettyCookie(String comment) {
    DefaultCookie nettyCookie = new DefaultCookie("name", "value");
    nettyCookie.setDomain("domain");
    nettyCookie.setPath("path");
    nettyCookie.setSecure(false);
    nettyCookie.setComment(comment);
    nettyCookie.setMaxAge(1);
    nettyCookie.setVersion(1);
    return nettyCookie;
  }
}
