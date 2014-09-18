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

import org.opens.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.opens.tanaguru.rules.elementchecker.link.LinkTitlePertinenceChecker;
import org.opens.tanaguru.rules.elementselector.LinkElementSelector;

/**
 * Implementation of the rule 6.2.1 of the referential Rgaa 3.0. <br/> For
 * more details about the implementation, refer to <a
 * href="http://www.tanaguru.org/en/content/aw22-rule-6-2-1">the rule 6.2.1
 * design page.</a>
 *
 * @see <a
 * href="http://www.accessiweb.org/index.php/accessiweb-html5aria-liste-deployee.html#test-6-2-1">
 * 6.2.1 rule specification</a>
 *
 */
public class Rgaa30Rule060201 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * 
     */
    public Rgaa30Rule060201() {
        super(new LinkElementSelector(false), new LinkTitlePertinenceChecker());
    }

}
