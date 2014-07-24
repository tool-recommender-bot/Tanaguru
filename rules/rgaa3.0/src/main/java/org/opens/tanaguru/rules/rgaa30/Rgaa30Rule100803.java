/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2014  Open-S Company
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */

package org.opens.tanaguru.rules.rgaa30;

import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.ruleimplementation.AbstractDetectionPageRuleImplementation;
import org.opens.tanaguru.rules.elementselector.MultipleElementSelector;
import static org.opens.tanaguru.rules.keystore.HtmlElementStore.*;
import static org.opens.tanaguru.rules.keystore.RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG;

/**
 * Implementation of the rule 10.8.3 of the referential Rgaa 3.0.
 * <br/>
 * For more details about the implementation, refer to <a href="http://www.tanaguru.org/en/content/aw22-rule-10-8-3">the rule 10.8.3 design page.</a>
 * @see <a href="http://www.accessiweb.org/index.php/accessiweb-html5aria-liste-deployee.html#test-10-8-3"> 10.8.3 rule specification</a>
 *
 */
public class Rgaa30Rule100803 extends AbstractDetectionPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa30Rule100803 () {
        super(
                new MultipleElementSelector(OBJECT_ELEMENT, APPLET_ELEMENT, EMBED_ELEMENT),
                // solution when at least one element is found
                TestSolution.NEED_MORE_INFO,
                // solution when no element is found
                TestSolution.NOT_APPLICABLE,
                // manual check message
                MANUAL_CHECK_ON_ELEMENTS_MSG,
                null);
    }

}
