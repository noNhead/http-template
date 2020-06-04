package com.epam.izh.rd.online.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public interface ObjectMapperFactory {

    ObjectMapper getObjectMapper() throws IOException;

}
