/**
 * Copyright 2014 by Tizra Inc.
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999-2008 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000-2008 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the "GNU LIBRARY GENERAL PUBLIC LICENSE"), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 */
package com.lowagie.text.pdf.parser;

/**
 * @author dgd
 */
public abstract class ParsedTextImpl implements TextAssemblyBuffer {
	private final String text;
	private float _ascent;
	private float _descent;
	private Vector _startPoint;
	private Vector _endPoint;
	float _spaceWidth;

	/**
	 * @param text
	 * @param startPoint
	 *            Initial rendering spot
	 * @param ascent
	 *            font ascent above baseline
	 * @param descent
	 *            font descent below the baseling
	 * @param width
	 *            What is the width of the space in this font....
	 */
	ParsedTextImpl(String text, Vector startPoint, Vector endPoint,
			float ascent, float descent, float spaceWidth) {
		this.text = text;
		_startPoint = startPoint;
		_endPoint = endPoint;
		_ascent = ascent;
		_descent = descent;
		_spaceWidth = spaceWidth;
	}

	/**
	 * @return
	 * @see com.lowagie.text.pdf.parser.ParsedText#getText()
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * @return The width, in user space units, of a single space character in
	 *         the current font
	 */
	public float getSingleSpaceWidth() {
		return _spaceWidth;
	}

	public float getAscent() {
		return _ascent;
	}

	public float getDescent() {
		return _descent;
	}

	public float getWidth() {
		return getEndPoint().subtract(getStartPoint()).length();
	}

	/**
	 * @return a vector in User space representing the start point of the text
	 */
	public Vector getStartPoint() {
		return _startPoint;
	}

	/**
	 * @return a vector in User space representing the end point of the text
	 *         (i.e. the starting point of the text plus the width of the text,
	 *         transformed by the applicable transformation matrices)
	 */
	public Vector getEndPoint() {
		return _endPoint;
	}
}
