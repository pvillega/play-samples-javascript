// Web Worker code, tries to find prime numbers using a poor algorithm. This should not block the browser
var n = 1;
var millisecondsToWait = 500;

//calculate the prime number
function calculate(){}

    search: while (true) {
      //break every 1000 iterations
      if(n % 1000) {
        // we execute a batch every 500 ms
        setTimeout(function() { calculate() }, millisecondsToWait);
        return;
      }

      n += 1;
      // check for all divisors of the number until its square root. If none is found, it's a prime
      for (var i = 2; i <= Math.sqrt(n); i += 1){
        if (n % i == 0) {
            continue search;
        }
      }
      // found a prime, communicate with the window via a message
      postMessage(n);
    }
}

// we execute a batch every 500 ms
setTimeout(function() { calculate() }, millisecondsToWait);

