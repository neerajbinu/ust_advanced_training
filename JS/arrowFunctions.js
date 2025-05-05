//Syntax
// const function_name = (parameters)=> some_code

//Having a siongle statement inside the arrow function
// const hello=(name)=> console.log(`Hello ${name}!`)

//Having more than one statement inside the arrow function
// const hello=(name,age)=>{
//     console.log(`Hi ${name}`);
//     console.log(`You are ${age} years old`);
// }
function hello()
{
let arr=[100,200,300,400,500]

//map function
const mappedArr=arr.map(num=>num *2)
console.log(mappedArr)

//filter function
const filterArr=arr.filter(num=>num%2==0)
console.log(filterArr)

//reduce function -- reduce to a single value
//Here 0 is the value of the accumulator
const sum=arr.reduce((acc,num)=>acc+num,0)
console.log(sum)

console.log(arr)
}

hello();