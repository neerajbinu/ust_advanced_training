import { useState } from "react";

function Fibonacci()
{  
 //Capturing the number user enters into the input box
    const[input,setInput]=useState("")
    const[output,setOutput]=useState([])

    //to handle the inout change when the user enters something into the textbox
    function handleInputChange(e)
    {   
        setInput(e.target.value)
    }

    function calculateFibonacci()
    {
        
        //converting the user input from string to an integer
        let n=parseInt(input);
        if(isNaN(n)||n<=0)
        {
                alert("Please enter a valid number!!")
        }
        let ans=[]
        ans.push(0)
        ans.push(1)
        let i=0
        for(i=0;i<n;++i)
        {
            ans.push(ans[i]+ans[i+1])
        }
         console.log(ans)
         setOutput(ans);
        
    }

    return(
    <div>
    <h2>Fibonacci Series</h2>
    <label for="txtInput">Enter a number</label>
     <input type="text" name="number" id="txtInput" onChange={handleInputChange}></input> <br></br><br></br>

     {/*WRONG !!
      <label for="btnGenerate">Submit</label>
     <input type="button" name="submit" id="btnGenerate" onClick={calculateFibonacci.js}></input> */}
     <button id="btnGenerate" name="generateButton" value="GenerateFibonacci" onClick={calculateFibonacci}> Generate Fibonacci</button>
     <div id="divResult">
        <ul>
            {
                output.map((num,index)=>
                (
                    <li key={index}>{num}</li>
                 ))
            }
        
        </ul>
     </div>
     </div>
    );
}
export default Fibonacci;