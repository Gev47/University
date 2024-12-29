const API_BASE_URL = 'http://localhost:8080';

// Fetch and display Teachers
function fetchTeachers() {
    fetch(`${API_BASE_URL}/teachers`)
        .then(response => response.json())
        .then(data => {
            const teachersList = document.getElementById('teachersList');
            teachersList.innerHTML = `
                <ul class="list-group">
                    ${data.map(teacher => `
                        <li class="list-group-item">
                            <strong>${teacher.fullName}</strong> - ${teacher.department} (${teacher.academicDegree})
                        </li>
                    `).join('')}
                </ul>
            `;
        })
        .catch(error => console.error('Error fetching teachers:', error));
}

// Fetch and display Subjects
function fetchSubjects() {
    fetch(`${API_BASE_URL}/subjects`)
        .then(response => response.json())
        .then(data => {
            const subjectsList = document.getElementById('subjectsList');
            subjectsList.innerHTML = `
                <ul class="list-group">
                    ${data.map(subject => `
                        <li class="list-group-item">
                            <strong>${subject.name}</strong> - ${subject.hours} hours (${subject.mandatory ? 'Mandatory' : 'Optional'})
                        </li>
                    `).join('')}
                </ul>
            `;
        })
        .catch(error => console.error('Error fetching subjects:', error));
}

// Fetch and display Class Sessions
function fetchClassSessions() {
    fetch(`${API_BASE_URL}/class-sessions`)
        .then(response => response.json())
        .then(data => {
            const classSessionsList = document.getElementById('classSessionsList');
            classSessionsList.innerHTML = `
                <ul class="list-group">
                    ${data.map(session => `
                        <li class="list-group-item">
                            <strong>${session.date} - ${session.time}</strong>: ${session.classType} in ${session.auditorium} (Group: ${session.groupName})
                        </li>
                    `).join('')}
                </ul>
            `;
        })
        .catch(error => console.error('Error fetching class sessions:', error));
}
