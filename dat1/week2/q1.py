import numpy as np
yorkTaxis = [0.00, 1.00, 3.00, 6.00, 8.00, 13.00, 16.10, 17.60, 19.90]
leedsTaxis = [0.50, 1.20, 2.30, 5.00, 7.80, 14.30, 17.10, 17.30, 20.90]
leedsTaxis = np.array(leedsTaxis)
yorkTaxis = np.array(yorkTaxis)
diff = np.subtract(yorkTaxis, leedsTaxis)
print(diff)