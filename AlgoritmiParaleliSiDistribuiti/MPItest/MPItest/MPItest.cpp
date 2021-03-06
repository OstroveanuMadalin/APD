#include <stdio.h>
#include "stdafx.h"
#include "mpi.h"
#include <random>
#include <stdlib.h>
#include <iostream>
using namespace std;
#define MASTER 0
#define n 10


int main(int argc, char *argv[])
{
	int nrProc, id, sum = 0, i, buc, sumTotal = 0;
	int v[n];
	
	

	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD, &nrProc);
	MPI_Comm_rank(MPI_COMM_WORLD, &id);
	for (i = 0; i < n; i++)
	{
		v[i] = rand() % 100 + 1;
	}

	buc = n / nrProc;
	for (i = 0; i < buc; i++)
	{
		sum = sum + v[id*buc + i];
	}

		if (id != MASTER)
		{
			MPI_Send(&sum, 1, MPI_INT, MASTER, 0, MPI_COMM_WORLD);
		}
		else 
		{
			MPI_Recv(&sum, 1, MPI_INT, id, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
			sumTotal = sumTotal + sum;
			
		}

	
	cout << "suma totale este:" << sumTotal << endl;

	MPI_Finalize();
	
}