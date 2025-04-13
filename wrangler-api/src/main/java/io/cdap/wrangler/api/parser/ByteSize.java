/*
 * Copyright © 2025 Cask Data, Inc.
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
import io.cdap.wrangler.api.parser;

public class ByteSize {
    private final double bytes;

    public ByteSize(String value) {
        this.bytes = parseBytes(value);  // Removed super(value)
    }

    private double parseBytes(String value) {
        String val = value.toUpperCase();
        if (val.endsWith("KB")) return Double.parseDouble(val.replace("KB", "")) * 1024;
        if (val.endsWith("MB")) return Double.parseDouble(val.replace("MB", "")) * 1024 * 1024;
        if (val.endsWith("GB")) return Double.parseDouble(val.replace("GB", "")) * 1024 * 1024 * 1024;
        if (val.endsWith("TB")) return Double.parseDouble(val.replace("TB", "")) * 1024d * 1024 * 1024 * 1024;
        return Double.parseDouble(val.replace("B", ""));
    }

    public long getBytes() {
        return (long) bytes;
    }
}
