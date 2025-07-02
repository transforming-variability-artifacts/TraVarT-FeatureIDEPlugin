package de.kit.kastel.travart.fide;

import java.util.logging.Logger;

import at.jku.cps.travart.core.common.IStatistics;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;

public class FeatureIdeStatistics implements IStatistics<FeatureModel> {

	private static FeatureIdeStatistics instance;
	
	private FeatureIdeStatistics() {}

	public static FeatureIdeStatistics getInstance() {
		if (instance == null) {
			instance = new FeatureIdeStatistics();
		}
		return instance;
	}

	@Override
	public int getVariabilityElementsCount(FeatureModel model) {
		return model.getNumberOfFeatures();
	}

	@Override
	public int getConstraintsCount(FeatureModel model) {
		return model.getConstraintCount();
	}

	@Override
	public void logModelStatistics(Logger logger, FeatureModel model) {
		logger.info("Not yet implemented");
	}

}
