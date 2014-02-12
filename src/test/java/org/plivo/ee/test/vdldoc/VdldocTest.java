package org.plivo.ee.test.vdldoc;

import java.io.File;

import org.omnifaces.vdldoc.VdldocGenerator;

public class VdldocTest {
	public static void main(String[] args) {
		VdldocGenerator generator = new VdldocGenerator();
		generator.setWindowTitle("plivo-java-ee - vdldoc");
		generator.setDocTitle("plivo-java-ee - vdldoc");
		generator.setOutputDirectory(new File("docs/vdldoc"));
		// Optional.
		// generator.setFacesConfig(new File("/path/to/faces-config.xml"));
		generator.addTaglib(new File(
				"src/main/resources/META-INF/plivo-java-ee.taglib.xml"));
		generator.generate();
	}
}
