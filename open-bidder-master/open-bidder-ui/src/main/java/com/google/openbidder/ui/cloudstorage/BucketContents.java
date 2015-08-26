/*
 * Copyright 2012 Google Inc. All Rights Reserved.
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

package com.google.openbidder.ui.cloudstorage;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.Collections;

/**
 * Represents a listing of the contents of a {@link Bucket}.
 */
public class BucketContents {

  private final String bucketName;
  private final ImmutableList<BucketObject> bucketObjects;

  public BucketContents(String bucketName) {
    this(bucketName, Collections.<BucketObject>emptyList());
  }

  public BucketContents(String bucketName, Iterable<BucketObject> bucketObjects) {
    this.bucketName = Preconditions.checkNotNull(bucketName);
    this.bucketObjects = ImmutableList.copyOf(bucketObjects);
  }

  public String getBucketName() {
    return bucketName;
  }

  public ImmutableList<BucketObject> getBucketObjects() {
    return bucketObjects;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).omitNullValues()
        .add("bucketName", bucketName)
        .add("bucketObjects", bucketObjects)
        .toString();
  }
}
