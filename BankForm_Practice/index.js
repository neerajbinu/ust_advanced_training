
        // Do not change these hardcoded transactions
        const transactions = [
            {
                description: "Transfer to Mr A",
                amount: 1000,
                type: "WITHDRAWL",
            },
            {
                description: "Salary March 2022",
                amount: 50000,
                type: "DEPOSIT",
            },
            {
                description: "House Rent",
                amount: 4000,
                type: "WITHDRAWL",
            },
            {
                description: "Receive from Mr B",
                amount: 2000,
                type: "DEPOSIT",
            },\
        ];
        const button = document.getElementById("search-btn");
        button.addEventListener("click",populateTransactions)
        

        function populateTransactions(e) {
            if (e) e.preventDefault();
            // On page load, populate table with all the transactions
            // When the user selects a particular transaction type from the dropdown, display transactions with that particular type
            // For example :
            // 1) Initial page load will contain 4 transactions 
            // If the user selects Transaction Type as DEPOSIT, you should display transactions which has type: "DEPOSIT" only
            // Similarly if the user selects Transaction Type as WITHDRAWL, you should display transactions which has type: "WITHDRAWL" only
            // If user selects All, then you need to display all transactions again
            // Add transactions to  <tbody id="transactionTableBody"></tbody> dynamically using JavaScript
            const type = document.getElementById("type")
            const tableBody = document.getElementById("transactionTableBody")
            console.log(type.value)
            if (type.value === "All") {
                // console.log("Hiiiii")

                const rows = transactions.map((value) =>

                    `
                    <tr class=${value.type.toLowerCase()}>
                        <td>${value.description}</td>
                         <td>${value.amount}</td>
                          <td>${value.type}</td>
                    </tr>      
                `

                ).join('')
                console.log(rows)
                tableBody.innerHTML = rows;


            }
            else {
                getTransactions(type.value)
            }




        }

        function getTransactions(selectedType) {
            // This is a helper function which will accept transaction type as a parameter  "All", "DEPOSIT", "WITHDRAWL"
            // Based on transaction type it will return all transactions or transactions with a particular type
            const table = document.getElementById("transactionTableBody")
            if (selectedType === "DEPOSIT") {
                const depositRows = transactions.filter((value) => {
                    return value.type === "DEPOSIT"
                })
                console.log(depositRows)
                const rows = depositRows.map((value) =>
                    `
            <tr class=${value.type.toLowerCase()}>
                <td>${value.description}</td>
                <td>${value.amount}</td>
                <td>${value.type}</td>
            </tr>    
            `).join('')
                console.log(rows)
                table.innerHTML = rows

            }
            else {
                const withdrawlRows = transactions.filter((value) => {
                    return value.type === "WITHDRAWL"
                })
                console.log(withdrawlRows)
                const rows = withdrawlRows.map((value) =>
                    `
        <tr class=withdrawl>
            <td>${value.description}</td>
            <td>${value.amount}</td>
            <td>${value.type}</td>
         </tr>   
        `).join('')
         console.log(rows)
         table.innerHTML=rows

            }
        }
        populateTransactions()

