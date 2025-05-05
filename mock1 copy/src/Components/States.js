import { useState } from "react";
import React from "react";
// You can use hooks only inside functional components
// Hooks should be called in the exact same order. They can't be inside a conditional statement or something like that..They cannot be nested inside anything
function States()
{
    //useState(arg)...Here arg should be the default state of the hook
    // const[count,setCount]=useState(arg)
    // Here count is the current state and setCount denotes the updated state
    const[count,setCount]=useState(countInitial())

    function countInitial()
    {
        console.log("I have run")
        return 4
    }
        
    function decrementCount()
    {
        setCount( prevCount=>prevCount-1)
    }
    
     function incrementCount()
    {
        //setCount(prevCount=>prevCount+1)
        setCount(addPrevCount)
    }

    function addPrevCount(prevCount)
    {
        return prevCount+1;
    }

    return (
        <div>
            {/* <h2>Fibonacci Series</h2>
            <label for="txtInput">Enter a number</label>
            <input type="text" name="number" id="txtInput"></input> */}
            <h2>Counter</h2>
            <button onClick={decrementCount}>-</button>
            <span>{count}</span>
            <button onClick={incrementCount}>+</button>



        </div>

    );
}
export default States;


