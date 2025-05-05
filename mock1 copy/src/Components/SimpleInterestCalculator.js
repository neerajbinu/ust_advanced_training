import React, { useEffect, useState } from "react";

function SimpleInterestCalculator() {
  const[principal,setPrincipal]=useState("")
  const[months,setMonths]=useState("")
  const[interest,setInterest]=useState("")
  const[valid,setValid]=useState(false)
  const[errorMsg,setErrorMsg]=useState("")
  const[output,setOutput]=useState(null)

  //useEffect is used for validating the input
  useEffect(()=>{
    let p=Number(principal)
    let m=Number(months)

    let i=Number(interest)
    // Only run validation when the inputs are not empty
    if(principal && months && interest)
    {
    //note that it is !isNan and not !Nan
    if((!isNaN(p)&&p>=100000&&p<=999999) && (!isNaN(m)) && (!isNaN(i) && !Number.isInteger(i)))
    {
      setValid(true)
    }
    else
    {
      setValid(false)
      setErrorMsg("Enter Proper Inputs")
    }
  }
    else
    {  // Do not show error message if fields are empty
      setValid(false)
      setErrorMsg("")
    }
  
  },[principal,months,interest])
  // useEffect will run after the component mounts (initial render).
  // After every subsequent render, it will only run if any of the values in the dependency array (principal, months, or interest) have changed since the last render.
  // This prevents unnecessary re-renders or unnecessary effect executions when the values you're interested in have not changed.
 
  function calculateSI()
  {
    let p=Number(principal)
    let m=Number(months)
    let i=Number(interest)

    let result=(p*m*i)/100
    setOutput(result)
  }
  
  return(
    <div>
      <label for="principal">Principal</label><br></br>
      <input type="number" id="principal" name="principal" onChange={(e)=>setPrincipal(e.target.value)}></input><br></br><br></br>
      <label for="months">Months</label><br></br>
      <input type="number" id="months" name="months" onChange={(e)=>{setMonths(e.target.value)}}></input><br></br><br></br>
      <label for="interest">Interest</label><br></br>
      <input type="number" id="interest" name="interest" onChange={(e)=>setInterest(e.target.value)}></input><br></br><br></br>
      {
        valid===false&&(
          <div>
           <p style={{color:"red"}}> {errorMsg} </p> 
            {/* displaying errorMsg for incorrect inputs */}
          </div>
        )
      }

      <button onClick={calculateSI} disabled={!valid}>Result</button>

      {/* Using isValid directly would result in the opposite of the desired behavior (disabling the button when the form is valid).
      Negating the value with !isValid ensures the button is disabled when the form is invalid and enabled when the form is valid. */}
      {output!=null && (
        <div>
          SimpleInterest: Rs{output.toFixed(2)}
          {/* .toFixed(2) means 2 decimal places after the point */}
        </div>
      )}
    </div>

  );
  
}
//Note for external CSS in react use className="error" and not class="error" as class is a reserved keyword in JS 

export default SimpleInterestCalculator;
