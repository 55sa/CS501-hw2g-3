package com.example.hw2g_3

class test {
    fun calculation(expression: String): Float{
        var stack=Stack<Float>()
        var pre='+'
        var result=0f
        var decimal=1
        var pos=0
        var cur=0f
        stack.push(0f)

        while (pos<expression.length){
            val start=pos
            while (pos<expression.length && (expression.get(pos).isDigit()|| expression.get(pos)=='.')){
                pos++
            }
            cur=expression.substring(start,pos).toFloat()

            if(pos==expression.length){
                if(pre=='+'){
                    stack.push(cur)

                }
                else if(pre=='-'){
                    stack.push(-cur)

                }
                else if(pre=='*'){
                    stack.push(stack.pop()!! * cur)

                }
                else if(pre=='/'){
                    stack.push(stack.pop()!! / cur)

                }
                break

            }



            if((!expression.get(pos).isDigit() && expression.get(pos)!='.')){
                if(pre=='+'){
                    stack.push(cur)
                    pre=expression.get(pos)
                }
                else if(pre=='-'){
                    stack.push(-cur)
                    pre=expression.get(pos)
                }
                else if(pre=='*'){

                    stack.push(stack.pop()!! * cur)
                    pre=expression.get(pos)
                }
                else if(pre=='/'){
                    stack.push(stack.pop()!! / cur)
                    pre=expression.get(pos)
                }
                cur=0f
                pos++
            }

        }
        while(!stack.isEmpty()){
            result = result + stack.pop()!!
        }
        return result
    }


}
fun main(){

   var expression="1 + 1"
    println(calculation(expression.replace(" ","")))

}
