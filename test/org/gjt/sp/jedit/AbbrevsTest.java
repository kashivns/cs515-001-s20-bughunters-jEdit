/*
 * jEdit - Programmer's Text Editor
 * :tabSize=8:indentSize=8:noTabs=false:
 * :folding=explicit:collapseFolds=1:
 *
 * Copyright © 2020 jEdit contributors
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.gjt.sp.jedit;


import org.jedit.io.Native2ASCIIEncoding;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class AbbrevsTest {

    public static View view;
    public static Buffer buffer;

    @BeforeClass
    public static void setUp()
    {
        System.out.println("Pehla print");
        String args [] = {"./test.java"};
        jEdit.main(args);
        System.out.println("Dusra print");
        view  =  jEdit.getActiveView();
        buffer = jEdit.openFileAfterStartup("./test.java");
    }


    @Test
    public void testExpandAbbrev() throws IOException
    {
        Abbrevs.expandAbbrev(view,true);
        String bufferText = buffer.getText();
        System.out.println(bufferText+"Buffer text ");
        Assert.assertEquals("for(int i = 0; i < <10; i++)\n" +
                "{\n" +
                "\t\n" +
                "}", bufferText);
    }
}
