package com.directi.training.lsp.example_refactored;

public class SquareTest
{
//    @Test
    public void testSetWidth_Square()
    {
        Square square = new Square();
        square.setSide(5);
        square.setSide(4);
//        assertEquals(4, square.getSide());
//        assertEquals(16, square.getArea());
    }
}
