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

import at.jku.cps.travart.core.common.Format;

public final class FeatureIdeFormat extends Format {

	private static FeatureIdeFormat fideFormat;

	public static FeatureIdeFormat getInstance() {
		if (fideFormat == null) {
			fideFormat = new FeatureIdeFormat();
		}
		return fideFormat;
	}

	public static final String LANGUAGE_NAME = "FeatureIde";
	public static final String FILE_EXTENSION = ".xml";

	private FeatureIdeFormat() {
		super(LANGUAGE_NAME, FILE_EXTENSION, true, true);
	}
}
