package com.ivar.enterprise.ap.domain;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.*;
import org.bson.codecs.configuration.CodecRegistry;

public class CountryCodec implements Codec<Country> {

    private final CodecRegistry codecRegistry;

    public CountryCodec(final CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }
    public void encode(BsonWriter writer, Country t, EncoderContext ec) {
        Document document = new Document();
        document.append("code", t.getCode());
        document.append("id", t.getId());
        document.append("name", t.getName());
        document.append("continent", t.getContinent());
        document.append("wikiLink", t.getWikiLink());
        writer.writeStartDocument();
        Codec stringCodec = codecRegistry.get(String.class);
        Codec longCodec = codecRegistry.get(Long.class);
        writer.writeName("code");
        ec.encodeWithChildContext(stringCodec, writer, t.getCode());
        writer.writeName("id");
        ec.encodeWithChildContext(longCodec, writer, t.getId());
        writer.writeName("name");
        ec.encodeWithChildContext(stringCodec, writer, t.getName());
        writer.writeName("continent");
        ec.encodeWithChildContext(stringCodec, writer, t.getContinent());
        writer.writeName("wikiLink");
        ec.encodeWithChildContext(stringCodec, writer, t.getWikiLink());
        writer.writeEndDocument();
    }

    public Class<Country> getEncoderClass() {
        return Country.class;
    }

    public Country decode(BsonReader reader, DecoderContext dc) {
        Codec stringCodec = codecRegistry.get(String.class);
        Codec longCodec = codecRegistry.get(Long.class);

        Country country = new Country();

        reader.readStartDocument();
        reader.readName("code");
        country.setCode((String)stringCodec.decode(reader, dc));
        reader.readName("id");
        country.setId((Long)longCodec.decode(reader,dc));
        reader.readName("name");
        country.setName((String)stringCodec.decode(reader, dc));
        reader.readName("continent");
        country.setContinent((String)stringCodec.decode(reader, dc));
        reader.readName("wikiLink");
        country.setWikiLink((String)stringCodec.decode(reader, dc));

        reader.readEndDocument();

        return country;
    }

}
