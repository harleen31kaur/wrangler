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

public class TimeDuration  {
    private final double millis;

    public TimeDuration(String value) {
        this.millis = parseMillis(value);  // Removed super(value)
    }

    private double parseMillis(String value) {
        String val = value.toLowerCase();
        if (val.endsWith("ms")) return Double.parseDouble(val.replace("ms", ""));
        if (val.endsWith("s")) return Double.parseDouble(val.replace("s", "")) * 1000;
        if (val.endsWith("m")) return Double.parseDouble(val.replace("m", "")) * 60 * 1000;
        if (val.endsWith("h")) return Double.parseDouble(val.replace("h", "")) * 60 * 60 * 1000;
        return 0;
    }

    public long getMilliseconds() {
        return (long) millis;
    }
}
