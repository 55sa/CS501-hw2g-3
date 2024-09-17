package com.example.hw2g_3

class test {
    fun calculation(expression: List<String>): Float{
        var stack=Stack<Float>()
        var pre="+"
        var result=0f
        var decimal=1
        var pos=0
        var cur=0f
        stack.push(0f)

        while (pos<expression.size){




            cur=expression.get(pos).toFloat()
            pos++


            if(pos==expression.size){
                if(pre.equals("+")){
                    stack.push(cur)

                }
                else if(pre.equals("-")){

                    stack.push(-cur)

                }
                else if(pre.equals("*")){
                    stack.push(stack.pop()!! * cur)

                }
                else if(pre.equals("/")){
                    stack.push(stack.pop()!! / cur)

                }
                break

            }




            if(pre.equals("+")){
                stack.push(cur)
                pre=expression.get(pos)
            }
            else if(pre.equals("-")){
                stack.push(-cur)
                pre=expression.get(pos)
            }
            else if(pre.equals("*")){

                stack.push(stack.pop()!! * cur)
                pre=expression.get(pos)
            }
            else if(pre.equals("/")){
                stack.push(stack.pop()!! / cur)
                pre=expression.get(pos)
            }

            cur=0f
            pos++
        }


        while(!stack.isEmpty()){
            result = result + stack.pop()!!
        }
        return result
    }


}
fun main(){

   var expression="1--1"
  println(calculation(listOf("1","-","-1")))



}
