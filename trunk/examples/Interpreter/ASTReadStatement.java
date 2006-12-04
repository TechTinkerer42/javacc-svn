/* Copyright (c) 2006, Sun Microsystems, Inc.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Sun Microsystems, Inc. nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */


/* JJT: 0.2.2 */




public class ASTReadStatement extends SimpleNode {
  String name;

  ASTReadStatement(int id) {
    super(id);
  }


  public void interpret()
  {
     Object o;
     byte[] b = new byte[64];
     int i;

     if ((o = symtab.get(name)) == null)
        System.err.println("Undefined variable : " + name);

     if (o instanceof Boolean)
     {
        System.out.print("Enter a value for \'" + name + "\' (boolean) : ");
        System.out.flush();
        try
        {
           i = System.in.read(b);
           symtab.put(name, new Boolean((new String(b, 0, 0, i - 1)).trim()));
        } catch(Exception e) { System.exit(1); }
     }
     else if (o instanceof Integer)
     {
        System.out.print("Enter a value for \'" + name + "\' (int) : ");
        System.out.flush();
        try
        {
           i = System.in.read(b);
           symtab.put(name, new Integer((new String(b, 0, 0, i - 1)).trim()));
        } catch(Exception e) {
           System.out.println("Exceptio : " + e.getClass().getName());
           System.exit(1);
        }
     }
  }
}
