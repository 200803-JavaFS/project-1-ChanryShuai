const url = "http://localhost:8080/project1/"

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }

    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    })

    if (resp.status === 200) {
        console.log(resp)
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN.";

        let resp = await fetch(url + "reimbursement", {
            credentials: 'include',
        });
        //get all button show
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find All Reimbursements";
        button.onclick = findAllFunc;
        document.getElementById("table-row").appendChild(button);

        //get pending button show
        let button2 = document.createElement('button');
        button2.className = "btn btn-success";
        button2.id = "findPendBtn";
        button2.innerText = "Pending Reimbursements";
        button2.onclick = FindPendFunc;
        document.getElementById("formbtn").appendChild(button2);

        //get approved button show
        let button3 = document.createElement('button');
        button3.className = "btn btn-success";
        button3.id = "findAppBtn";
        button3.innerText = "Approved Reimbursements";
        button3.onclick = FindAppFunc;
        document.getElementById("formbtn").appendChild(button2);

        //get denied button show
        let button4 = document.createElement('button');
        button4.className = "btn btn-success";
        button4.id = "findDenyBtn";
        button4.innerText = "Denied Reimbursements";
        button4.onclick = FindDenyFunc;
        document.getElementById("formbtn").appendChild(button4);

    } else if (resp.status === 202) {
        console.log(resp)
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN.";

        let resp = await fetch(url + "reimbursement/" + user.username, {
            credentials: 'include',
        });
        //get past reimbursements button show
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "findByAuthorBtn";
        button.innerText = "Submitted Reimbursements";
        button.onclick = FindByAuthorFunc;
        document.getElementById("formbtn").appendChild(button);

        //submit reimbursement button show
        let button2 = document.createElement('button');
        button2.className = "btn btn-success";
        button2.id = "addReimbBtn";
        button2.innerText = "Submit a New Reimbursement";
        button2.onclick = AddFunc;
        document.getElementById("formbtn").appendChild(button2);

    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function findAllFunc() {

    document.getElementById("reimbbody").innerText = "";

    let resp = await fetch(url + "reimbursement", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();
        for (let reimb of data) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);

            document.getElementById("reimbbody").appendChild(row);
        }
    }
}

async function FindPendFunc() {
    document.getElementById("reimbbody").innerText = "";

    let resp = await fetch(url + "reimbursement/pending", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let datap = await resp.json();
        for (let reimb of datap) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);
            document.getElementById("reimbbody").appendChild(row);

            let inputid = document.createElement("input");
            inputid.placeholder = "input reimbursement ID";
            inputid.type = "text";
            inputid.id = "findOne";
            let buttonone = document.createElement('button');
            button.className = "btn btn-success";
            button.id = "findOneBtn";
            button.innerText = "Update Selected Reimbursement";
            button.onclick = findOneFunc;
            document.getElementById("selectone").appendChild(inputid);
            document.getElementById("selectone").appendChild(buttonone);

        }
    }
}

async function findOneFunc() {

    document.getElementById("reimbbody").innerText = "";

    let resp = await fetch(url + "reimbursement/" + document.getElementById("inputid").value.toString, {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();
        for (let reimb of data) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);

            document.getElementById("onebody").appendChild(row);

            let newstatus = document.createElement("input");
            inputid.placeholder = "approve/deny";
            inputid.type = "text";
            inputid.id = "newstatus";

            let newauthor = document.createElement("input");
            inputid.placeholder = "enter manager username";
            inputid.type = "text";
            inputid.id = "newauthor";

            let buttonone = document.createElement('button');
            button.className = "btn btn-success";
            button.id = "changeStatusBtn";
            button.innerText = "Change";
            button.onclick = UpdateStatusFunc(document.getElementById("onebody").value);
            document.getElementById("changestatus").appendChild(newstatus);
            document.getElementById("changestatus").appendChild(buttonone);
        }
    }
}
async function FindAppFunc() {
    document.getElementById("reimbbody").innerText = "";

    let resp = await fetch(url + "reimbursement/approved/", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let datap = await resp.json();
        for (let reimb of datap) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);

            document.getElementById("reimbbody").appendChild(row);
        }
    }
}

async function FindDenyFunc() {
    document.getElementById("reimbbody").innerText = "";

    let resp = await fetch(url + "reimbursement/denined/", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let datap = await resp.json();
        for (let reimb of datap) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);

            document.getElementById("reimbbody").appendChild(row);
        }
    }
}

async function FindByAuthorFunc() {


    if (resp.status === 200) {
        let datap = await resp.json();
        for (let reimb of datap) {
            console.log(reimb);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.reimbId;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            if (reimb.resolver != null) {
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimb.resolved;
                row.appendChild(cell4);
            } else {
                let cell4 = document.createElement("td");
                row.appendChild(cell4);
            }

            if (reimb.description != null) {
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimb.description;
                row.appendChild(cell5);
            } else {
                let cell5 = document.createElement("td");
                row.appendChild(cell5);
            }

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.author.username;
            row.appendChild(cell6);

            if (reimb.resolver != null) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.resolver.username;
                row.appendChild(cell7);
            } else {
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.rStatus.reimbStatus;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.rType.reimbType;
            row.appendChild(cell9);

            document.getElementById("reimbbody").appendChild(row);
        }
    }
}

async function AddFunc() {


    let ReimbDTO = {
        amount: ReimbDTO.amount,
        submitted: rSubmit,
        resolved: rResolve,
        description: rDescription,
        author_name: rAuthor,
        resolver_name: rResolver,
        statusString: rStatus,
        typeString: rType
    }

    console.log(ReimbDTO)

    let resp = await fetch(url + "reimbursement", {
        method: 'POST',
        body: JSON.stringify(ReimbDTO),
        credentials: "include"
    })

    if (resp.status === 201) {
        AddFunc()
    } else {
        document.getElementById("login-row").innerText = "Reimbursement could not be added.";

    }
}

async function UpdateStatusFunc(reimb) {

    let updateReimb = document.getElementById("onebody").value;

    let updatedReimb = {
        reimbId: updateReimb.reimbId,
        amount: updateReimb.amount,
        submitted: updateReimb.submitted,
        resolved: Date.now(),
        description: updateReimb.description,
        author_name: updateReimb.author,
        resolver_name: document.getElementById("newauthor"),
        statusString: document.getElementById("newstatus"),
        typeString: updateReimb.typeString
    }

    console.log(reimbursement)

    let resp = await fetch(url + "reimbursement/" + updateReimb.reimbId.toString, {
        method: 'POST',
        body: JSON.stringify(updatedReimb),
        credentials: "include"
    })

    if (resp.status === 201) {
        AddFunc()
    } else {
        document.getElementById("login-row").innerText = "Reimbursement could not be added.";

    }
}