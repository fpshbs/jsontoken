/**
 * Copyright 2010 Google Inc.
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
 *
 */
package net.oauth.jsontoken;


public class JsonToken<T extends Payload> {

  private final T payload;
  private final Envelope envelope;
  private final String signature;

  JsonToken(T payload, Envelope envelope, String signature) {
    this.payload = payload;
    this.envelope = envelope;
    this.signature = signature;
  }

  public T getPayload() {
    return payload;
  }

  public Envelope getEnvelope() {
    return envelope;
  }

  public String getToken() {
   return JsonTokenUtil.getBaseString(payload, envelope) + signature;
  }

  @Override
  public String toString() {
    return
        payload.toJson()
        + JsonTokenUtil.DELIMITER
        + envelope.toJson()
        + JsonTokenUtil.DELIMITER
        + signature;
  }
}
