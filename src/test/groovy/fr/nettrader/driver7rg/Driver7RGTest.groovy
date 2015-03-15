/*
    7 Days To Die region files driver
    Copyright (C) 2015 Nicolas Fortin

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package fr.nettrader.driver7rg

/**
 * Unit test
 */
class Driver7RGTest extends GroovyTestCase {

    void testParse() throws IOException {
        Driver7RG driver7RG = new Driver7RG();
        driver7RG.load(new File(Driver7RGTest.getResource("region_test.7rg").toURI()));
        assertEquals(1024, driver7RG.getChunkCount())

    }
}
