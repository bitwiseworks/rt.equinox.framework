/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ext.extclasspath.a.importer;

import ext.extclasspath.a.ExtClasspathExtTest;
import java.io.*;
import java.net.URL;
import org.eclipse.osgi.tests.bundles.AbstractBundleTests;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		AbstractBundleTests.simpleResults.addEvent(new ExtClasspathExtTest().toString());
		AbstractBundleTests.simpleResults.addEvent(getURLContent(this.getClass().getResource("/ext/extclasspath/a/extresource.txt"))); //$NON-NLS-1$
	}

	private String getURLContent(URL resource) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()));
		try {
			return br.readLine();
		} finally {
			br.close();
		}
	}

	public void stop(BundleContext context) throws Exception {
		// nothing
	}

}
