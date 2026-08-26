#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;

    // This does not change the original variables because
    // the function receives copies of their values, not their addresses.
}

int main() {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After swap: x = %d, y = %d\n", x, y);

    int a = 30;
    int b = 40;

    printf("\nBefore broken_swap: a = %d, b = %d\n", a, b);

    broken_swap(a, b);

    printf("After broken_swap: a = %d, b = %d\n", a, b);

    return 0;
}