function distinctCharacters(str)
{   
    //Convert String to a character array
    let charArray=str.split('');
    charArray.sort();
    for(i=0;i<charArray.length-1;i++)
    {
        if(charArray[i]==charArray[i+1])
        {
            return false;
        }
        
    }
    return true;
}

function main()
{
    let bool=distinctCharacters("NEERAJ");
    console.log(bool)
}

main();