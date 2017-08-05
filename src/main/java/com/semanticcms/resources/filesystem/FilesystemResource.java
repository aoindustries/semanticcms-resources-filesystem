/*
 * semanticcms-resources-filesystem - Redistributable sets of SemanticCMS resources stored in the filesystem.
 * Copyright (C) 2017  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-resources-filesystem.
 *
 * semanticcms-resources-filesystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-resources-filesystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-resources-filesystem.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.resources.filesystem;

import com.semanticcms.core.resources.Resource;
import java.io.File;

public class FilesystemResource extends Resource {

	private final File file;

	public FilesystemResource(FilesystemResourceStore store, String path, File file) {
		super(store, path);
		this.file = file;
	}

	@Override
	public FilesystemResourceStore getStore() {
		return (FilesystemResourceStore)store;
	}

	@Override
	public boolean isFilePreferred() {
		return true;
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public FilesystemResourceConnection open() {
		return new FilesystemResourceConnection(this, file);
	}
}
