package org.javacc.parser;

import junit.framework.TestCase;

public final class ExpansionTest extends TestCase {

    private Token t;
    private Expansion e;

    public void setUp() {
        t = new Token();
        t.beginColumn = 2;
        t.beginLine = 3;
        e = new Expansion();
        e.column = 5;
        e.line = 6;
    }
    public void testZeroOrOneConstructor() {
        ZeroOrOne zoo = new ZeroOrOne(t, e);
        assertEquals(t.beginColumn, zoo.column);
        assertEquals(t.beginLine, zoo.line);
        assertEquals(e, zoo.expansion);
        assertSame(e.parent, zoo);
    }

    public void testZeroOrMoreConstructor() {
        ZeroOrMore zom = new ZeroOrMore(t, e);
        assertEquals(t.beginColumn, zom.column);
        assertEquals(t.beginLine, zom.line);
        assertEquals(e, zom.expansion);
    }

    public void testRStringLiteralConstructor() {
        RStringLiteral r = new RStringLiteral(t, "hey");
        assertEquals(t.beginColumn, r.column);
        assertEquals(t.beginLine, r.line);
        assertEquals("hey", r.image);
    }

    public void testChoiceConstructor() {
        Choice c = new Choice(t);
        assertEquals(t.beginColumn, c.column);
        assertEquals(t.beginLine, c.line);
        c = new Choice(e);
        assertEquals(e.column, c.column);
        assertEquals(e.line, c.line);
        assertEquals(e, c.choices.firstElement());
    }

    public void testRJustNameConstructor() {
        RJustName r = new RJustName(t, "hey");
        assertEquals(t.beginColumn, r.column);
        assertEquals(t.beginLine, r.line);
        assertEquals("hey", r.label);
    }

    public void testSequenceConstructor() {
        Lookahead la = new Lookahead();
        Sequence s = new Sequence(t, la);
        assertEquals(t.beginColumn, s.column);
        assertEquals(t.beginLine, s.line);
        assertSame(la, s.units.firstElement());
    }
}
