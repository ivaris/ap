package com.ivar.enterprise.ap.domain;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class CountryCodecProvider implements CodecProvider {
        public <T> Codec<T> get(Class<T> type, CodecRegistry cr) {
            if (type == Country.class) {
                return (Codec<T>) new CountryCodec(cr);
            }
            return null;
        }

}
