/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.internal.classloader;

import com.google.common.hash.HashCode;
import org.gradle.internal.classpath.ClassPath;

import javax.annotation.Nullable;

/**
 * A {@link ClassLoaderFactory} that also stores the hash of each created classloader which is later retrievable via {@link #getHash(ClassLoader)}.
 */
public interface HashingClassLoaderFactory extends ClassLoaderFactory, ClassLoaderHasher {
    /**
     * Creates a {@link ClassLoader} with the given parent and classpath. Use the given hash
     * code, or calculate it from the given classpath when hash code is {@code null}.
     */
    ClassLoader createChildClassLoader(ClassLoader parent, ClassPath classPath, @Nullable HashCode implementationHash);
}
