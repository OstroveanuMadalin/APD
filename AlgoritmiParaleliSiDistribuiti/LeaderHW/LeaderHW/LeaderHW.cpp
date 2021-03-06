#include <random>
#include "mpi.h"
#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include<iostream>
#define MASTER 0
using namespace std;

int main(int argc, char** argv)
{
	int numprocs, procid, len;

	int n, n_master, max;
	MPI_Init(NULL, NULL);
	MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
	MPI_Comm_rank(MPI_COMM_WORLD, &procid);

	if (procid == MASTER) {
		n_master = rand() % 10 + 1;
	}
	else
	{
		n = rand() % 10 + 1;
	}
	if (procid != MASTER)
	{
		MPI_Send(&n, 1, MPI_INT, MASTER, 0, MPI_COMM_WORLD);
	}
	if (procid == MASTER)
	{
		MPI_Recv(&n, 1, MPI_INT, MPI_ANY_SOURCE, 0, MPI_COMM_WORLD, MPI_STATUSES_IGNORE);
		if (n > n_master)
		{
			max = n;
		}
	}

	cout << "Procesul cu numarul cel mai mare:" << max << endl;

	MPI_Finalize();
}
