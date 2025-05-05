//Properties are {key,value} pairs and methods are functions

const obj1={
    name:"NBN",
    age:32,
    gender:`M`,
    say:function (nationality) {console.log(`I am from ${nationality}`)}

}

const obj2={
    name:`Hari`,
    age:33,
    gender:`M`,
    say:function (nationality){console.log(`I am from ${nationality}`)}
}

console.log(obj2.name)
console.log(obj1.name)
obj1.say("INDIA")
obj2.say("INDIA")