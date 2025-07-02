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
package de.kit.kastel.travart.fide.factory.impl;

import de.kit.kastel.travart.fide.factory.IFeatureIdeFactory;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;

public class FeatureIdeFactory implements IFeatureIdeFactory {

	public static final String ID = "de.kit.kastel.travart.fide.factory.impl.FeatureIdeFactory"; 

	private FeatureIdeFactory() {}

	private static FeatureIdeFactory factory;

	// Factory as singleton object
	public static FeatureIdeFactory getInstance() {
		if (factory == null) {
			factory = new FeatureIdeFactory();
		}
		return factory;
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public FeatureModel create() {
		return new FeatureModel(ID);
	}
}
