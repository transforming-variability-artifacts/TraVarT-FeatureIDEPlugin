/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Kaan Berk Yaman
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.fide.io;

import java.util.List;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.IDeserializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.fide.factory.impl.FeatureIdeFactory;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;
import de.ovgu.featureide.fm.core.io.manager.FileHandler;
import de.ovgu.featureide.fm.core.io.xml.XmlFeatureModelFormat;

public class FeatureIdeDeserializer implements IDeserializer<FeatureModel> {

	@Override
	public FeatureModel deserialize(String serial, Format format) throws NotSupportedVariabilityTypeException {
		FeatureModel deserializedModel = FeatureIdeFactory.getInstance().create();
		FileHandler.loadFromString(serial, deserializedModel, new XmlFeatureModelFormat());
		return deserializedModel;
	}

	@Override
	public Iterable<Format> supportedFormats() {
		return List.of(FeatureIdeFormat.getInstance());
	}

}
