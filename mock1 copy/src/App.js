import './App.css';
import States from './Components/States';
import Fibonacci from './Components/Fibonacci';

function App() {
  return (
    <div className="App">
      <div class="container-fluid p-5 bg-primary text-white text-center">
  <h1>My First Bootstrap Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>
  
<div class="container mt-5">
  <div class="row">
    <div class="col-sm-4">
      <States/>
    </div>
    <div class="col-sm-4">
    <Fibonacci/>
    </div>
    <div class="col-sm-4">
      
    </div>
  </div>
</div>
    </div>
  );
}

export default App;
