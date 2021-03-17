const body = document.querySelector('tbody');

function start() {
    getAllStudents();
    document.getElementById('submit').addEventListener('click', createStudent);
}

start();

function createStudent(event) {
    event.preventDefault();

    const form = event.target.parentNode;
    const formData = new FormData(form);

    const firstName = formData.get('firstName');
    const lastName = formData.get('lastName');
    const facultyNumber = formData.get('facultyNumber');
    const grade = formData.get('grade');

    if (firstName.value == '' || lastName.value == '' || facultyNumber.value == '' || grade == '') {
        return;
    }

    const result = `
            <tr>
                <td>${firstName}</td>
                <td>${lastName}</td>
                <td>${facultyNumber}</td>
                <td>${Number(grade).toFixed(2)}</td>
            </tr>`;

    body.innerHTML += result;
    form.reset();
}


async function getAllStudents() {
    const url = 'http://localhost:3030/jsonstore/collections/students';

    const response = await fetch(url);
    const data = await response.json();

    Object.values(data).forEach(student => {
        const firstName = student.firstName;
        const lastName = student.lastName;
        const facultyNumber = student.facultyNumber;
        const grade = student.grade.toFixed(2);

        const result = `
            <tr>
                <td>${firstName}</td>
                <td>${lastName}</td>
                <td>${facultyNumber}</td>
                <td>${grade}</td>
            </tr>`;
        body.innerHTML += result;
    });
}