/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.config.xml.util;


/**
 * The {@link NodeValue} class contains the node name and its according value for an XML tag.
 * <p>
 * This class can be used for an intermediate conversion result of a single value for an XML tag.
 * The conversion can be done by using the according {@link NodeValueConverter}.
 * <p>
 * <b>Hint:</b> This class is immutable.
 * 
 * @author Michael Grammling - Initial Contribution
 */
public class NodeValue implements NodeName {

    private String nodeName;
    private Object value;


    /**
     * Creates a new instance of this class with the specified parameters.
     * 
     * @param nodeName the name of the node this object belongs to (must neither be null, nor empty)
     * @param value the value of the node this object belongs to (could be null or empty)
     * @throws IllegalArgumentException if the name of the node is null or empty
     */
    public NodeValue(String nodeName, Object value) throws IllegalArgumentException {
        if ((nodeName == null) || (nodeName.isEmpty())) {
            throw new IllegalArgumentException(
                    "The name of the node must neither be null nor empty!");
        }

        this.nodeName = nodeName;
        this.value = formatText(value);
    }

    private Object formatText(Object object) {
        // fixes a formatting problem with line breaks in text
        if (object instanceof String) {
            return ((String) object).replaceAll("\\n\\s*", " ").trim();
        }

        return object;
    }

    @Override
    public String getNodeName() {
        return this.nodeName;
    }

    /**
     * Returns the value of the node
     *
     * @return the value of the node (could be null or empty).
     */
    public Object getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "NodeValue [nodeName=" + nodeName + ", value=" + value + "]";
    }

}
