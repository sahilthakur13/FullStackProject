const apiKey = 'AIzaSyDWaA0tJGXfN9kijxPK_CfRzbkjOuJ_90w';
const customSearchEngineId = '45bdb3d06b2a244dc';

const searchInput = document.getElementById('search-input');
const searchbtn = document.getElementById('search-button');
const resultsContainer = document.getElementById('results-container');

searchbtn.addEventListener('click', () => {
    const query = searchInput.value;
    if (query.trim() !== '') {
        searchGoogle(query);
    }
});

function searchGoogle(query) {
    const url = `https://www.googleapis.com/customsearch/v1?key=${apiKey}&cx=${customSearchEngineId}&q=${encodeURIComponent(query)}`;
    
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const data = JSON.parse(xhr.responseText);
            displayResults(data.items);
        } else if (xhr.readyState === 4) {
            console.error('Error:', xhr.status);
        }
    };
    xhr.send();
}

function displayResults(items) {
    resultsContainer.innerHTML = '';

    if (items && items.length > 0) {
        items.forEach(item => {
            const resultItem = document.createElement('div');
            resultItem.innerHTML = `
                <h2><a href="${item.link}" target="_blank">${item.title}</a></h2>
                <p>${item.snippet}</p>
            `;
            resultsContainer.appendChild(resultItem);
        });
    } else {
        resultsContainer.innerHTML = 'No results found.';
    }
}
