package it.cnr.iasi.saks.xacmut.mutator.generator;

import java.io.File;

import org.w3c.dom.Node;

import it.cnr.isti.sedc.xacml.mutator.generator.MutantGenerator;
import it.cnr.isti.sedc.xacml.mutator.gui.MutantsGeneratorMainClass;

public class MutantGeneratorWrapper extends MutantGenerator {

	public MutantGeneratorWrapper(Node goldPolicyAsDom, File goldPolicyFile, MutantsGeneratorMainClass mutantsGeneratorMainClass) {
		super(goldPolicyAsDom, goldPolicyFile, mutantsGeneratorMainClass);
	}
	
	@Override
	protected Void doInBackground() {
		try {
			super.doInBackground();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;		
	}

	public void executeTheMutation() {
		try {
			this.doInBackground();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void done() {
		System.err.println("... possibly there is nothing to do here in this Wrapper.");
	}


}
