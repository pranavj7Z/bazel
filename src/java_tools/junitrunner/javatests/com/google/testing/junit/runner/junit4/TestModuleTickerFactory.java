// Copyright 2016 The Bazel Authors. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.testing.junit.runner.junit4;

import com.google.testing.junit.runner.util.Factory;
import com.google.testing.junit.runner.util.Ticker;

/**
 * A factory that supplies a {@link Ticker} for testing purposes.
 */
public final class TestModuleTickerFactory implements Factory<Ticker> {
  private final JUnit4RunnerTest.TestModule module;

  public TestModuleTickerFactory(JUnit4RunnerTest.TestModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Ticker get() {
    Ticker ticker = module.ticker();
    if (ticker == null) {
      throw new NullPointerException();
    }
    return ticker;
  }

  public static Factory<Ticker> create(JUnit4RunnerTest.TestModule module) {
    return new TestModuleTickerFactory(module);
  }
}