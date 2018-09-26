/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.factory.TanaguruCrawlerControllerFactory;


import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 *
 * @author rcharre
 */
@XmlTransient
public class TanaguruCrawlerServiceImpl{
    private static final Logger LOGGER = Logger.getLogger(TanaguruCrawlerServiceImpl.class);

    @Autowired
    private ParameterDataService parameterDataService;
    public void setParameterDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }

    public List<String> getUrlListByCrawlingFromUrlList(Audit audit, List<String> urlList){
        TanaguruCrawlerControllerImpl tngCrawler = new TanaguruCrawlerControllerFactory(parameterDataService).create(
                audit
        );

        for(String url : urlList){
            tngCrawler.addSeed(url);
        }
        tngCrawler.run();
        return tngCrawler.getResult();
    }

    public List<String> getUrlListByCrawlingFromUrl(Audit audit, String url){
        TanaguruCrawlerControllerImpl tngCrawler = new TanaguruCrawlerControllerFactory(parameterDataService).create(
                audit
        );
        tngCrawler.addSeed(url);
        tngCrawler.run();
        tngCrawler.waitUntilFinish();
        return tngCrawler.getResult();
    }
}