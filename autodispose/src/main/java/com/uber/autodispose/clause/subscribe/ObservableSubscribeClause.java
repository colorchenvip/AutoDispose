/*
 * Copyright (c) 2016. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.autodispose.clause.subscribe;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Subscribe clause for the around steps that match Observable's subscribe overloads.
 */
public interface ObservableSubscribeClause {

  <T> Observer<T> empty();

  <T> Observer<T> around(Consumer<? super T> onNext);

  <T> Observer<T> around(Consumer<? super T> onNext, Consumer<? super Throwable> onError);

  <T> Observer<T> around(Consumer<? super T> onNext, Consumer<? super Throwable> onError,
      Action onComplete);

  <T> Observer<T> around(Observer<T> observer);

  <T> Observer<T> around(Consumer<? super T> onNext, Consumer<? super Throwable> onError,
      Action onComplete, Consumer<? super Disposable> onSubscribe);
}