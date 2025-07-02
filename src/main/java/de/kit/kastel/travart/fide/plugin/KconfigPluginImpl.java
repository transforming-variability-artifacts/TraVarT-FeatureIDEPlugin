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
package de.kit.kastel.travart.fide.plugin;

import java.util.Collections;
import java.util.List;

import org.pf4j.Extension;

import at.jku.cps.travart.core.common.IDeserializer;
import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.common.IPlugin;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.common.IStatistics;
import de.kit.kastel.travart.fide.FeatureIdeStatistics;
import de.kit.kastel.travart.fide.io.FeatureIdeDeserializer;
import de.kit.kastel.travart.fide.io.FeatureIdeFormat;
import de.kit.kastel.travart.fide.io.FeatureIdeSerializer;
import de.kit.kastel.travart.fide.transformation.FeatureIdeModelTransformer;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;

@Extension
public class KconfigPluginImpl implements IPlugin<FeatureModel> {

	public static final String ID = "fide-plugin";

	@Override
	public IModelTransformer<FeatureModel> getTransformer() {
		return new FeatureIdeModelTransformer();
	}

	@Override
	public IDeserializer<FeatureModel> getDeserializer() {
		return new FeatureIdeDeserializer();
	}

	@Override
	public IStatistics<FeatureModel> getStatistics() {
		return FeatureIdeStatistics.getInstance();
	}

	@Override
	public ISerializer<FeatureModel> getSerializer() {
		return new FeatureIdeSerializer();
	}

	@Override
	public String getName() {
		return "FeatureIde";
	}

	@Override
	public String getVersion() {
		return "0.0.0";
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public List<String> getSupportedFileExtensions() {
		return Collections.unmodifiableList(List.of(FeatureIdeFormat.FILE_EXTENSION));
	}

	@Override
	public String getAbbreviation() {
		return FeatureIdeFormat.LANGUAGE_NAME;
	}
}
