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

import com.igormaznitsa.jbbp.JBBPParser
import fr.nettrader.driver7rg.format.Header
import fr.nettrader.driver7rg.format.Location

/**
 * Read Write driver for 7RG files
 */
class Driver7RG {
    private File regionFile
    private JBBPParser headerParser = JBBPParser.prepare(Driver7RG.class.getResourceAsStream("7rg-struct.c").getText());
    private List<Location> locations = new ArrayList<>();

    public void load(File regionFile) throws IOException {
        this.regionFile = regionFile;
        Header header = headerParser.parse(regionFile.newInputStream()).mapTo(Header.class);
        if(!"7rg".equals(header.magic)) {
            throw new IOException("Not a 7RG file");
        }
        for(Location location : header.locations) {
            if(location.offset != 0) {
                locations.add(location)
            }
        }
    }


    public int getChunkCount() {
        return locations.size();
    }
}
