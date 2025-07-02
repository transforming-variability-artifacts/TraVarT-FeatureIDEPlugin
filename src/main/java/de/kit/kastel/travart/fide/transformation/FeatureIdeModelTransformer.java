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
package de.kit.kastel.travart.fide.transformation;

import at.jku.cps.travart.core.transformation.*;
import at.jku.cps.travart.core.common.IStatistics;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.io.UVLSerializer;
import de.kit.kastel.travart.fide.FeatureIdeStatistics;
import de.kit.kastel.travart.fide.factory.impl.FeatureIdeFactory;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;
import de.ovgu.featureide.fm.core.io.manager.FileHandler;
import de.ovgu.featureide.fm.core.io.uvl.UVLFeatureModelFormat;
import de.vill.main.UVLModelFactory;

public class FeatureIdeModelTransformer extends AbstractBenchmarkingTransformer<FeatureModel> {

	@Override
	// Use FQN de.vill.model.FeatureModel when referring to UVL feature model format
	public FeatureModel transformInner(final de.vill.model.FeatureModel model, final String modelName, final STRATEGY strategy)
			throws NotSupportedVariabilityTypeException {
		var uvlSerializer = new UVLSerializer();
		var result = FeatureIdeFactory.getInstance().create();
		// "Transform" models by serializing and deserializing successively
		FileHandler.loadFromString(uvlSerializer.serialize(model), result, new UVLFeatureModelFormat());
		return result;
	}

	@Override
	public de.vill.model.FeatureModel transformInner(final FeatureModel model, final String modelName, final STRATEGY strategy)
			throws NotSupportedVariabilityTypeException {
		var serialized = FileHandler.saveToString(model, new UVLFeatureModelFormat());
		UVLModelFactory factory = new UVLModelFactory();
		return factory.parse(serialized);
	}

	@Override
	public IStatistics<FeatureModel> getTargetStatistics() {
		return FeatureIdeStatistics.getInstance();
	}
	
}
